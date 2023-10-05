import tkinter as tk
from tkinter import font

class MyGUI():

    # Initialize program
    def __init__(self):
        self.root = tk.Tk()
        super().__init__()
        self.root.title("Luke Devlin - X's and O's")
        self.root.geometry("400x410")
        self.createDisplay()
        self.createGrid()

        self.clicked = True     
        self.count = 0
        self.winnerX = False
        self.winnerO = False
        self.draw = False
        self.gameOver = False

        self.root.mainloop()

    # Creates display text
    def createDisplay(self):
        displayFrame = tk.Frame(self.root)
        displayFrame.pack(fill=tk.X)
        self.display = tk.Label(master=displayFrame, text='Ready?', font=font.Font(size=36, weight="bold"))
        self.display.pack(pady=10)

    # Creates the X and O board
    def createGrid(self):
        gridframe = tk.Frame(self.root, width=400, height=400)
        gridframe.pack()
        self.cells = {}

        # Makes a 3x3 button grid
        for row in range(3):
            self.root.rowconfigure(row, weight=1, minsize=50)
            self.root.columnconfigure(row, weight=1, minsize=75)
            for col in range(3):
                button = tk.Button(
                    master=gridframe,
                    text=" ",
                    font=font.Font(size=28, weight='bold'),
                    fg='black',
                    width=3,
                    height=2,
                    highlightbackground='lightblue'
                )

                # creates a list of buttons
                self.cells[(row, col)] = button
                button.grid(row=row, column=col, padx=5, pady=5, sticky="nsew")
                button.config(command=lambda btn=button: self.play(btn))

        # reset button
        resetButton = tk.Button(master=self.root, text="Reset", font=font.Font(size=20, weight="bold"), width=10, height=2, highlightbackground='lightblue', command=self.reset)
        resetButton.pack(pady=10)

    # updates display at the top of window
    def updateDisplay(self, button):
        if not self.clicked:
            self.display["text"] = "O's Turn"
        elif self.clicked:
            self.display["text"] = "X's Turn"
        
        if self.draw:
            self.display["text"] = "It's a Draw!"
        elif self.winnerX:
            self.display["fg"] = 'red'
            self.display["text"] = "X is the Winner!"
        elif self.winnerO:
            self.display["fg"] = 'green'
            self.display["text"] = "O is the Winner!"
    
    # resets game
    def reset(self):
        self.clicked = True
        self.count = 0
        self.winnerX = False
        self.winnerO = False
        self.draw = False
        self.gameOver = False

        for button in self.cells.values():
            button["text"] = " "
            button["fg"] = 'black'

        self.display["fg"] = "white"
        self.display["text"] = 'Ready?'

    # lets the user play the game
    def play(self, button):
        if not self.gameOver:
            # x starts 
            if button["text"] == " " and self.clicked and self.count < 9:
                button["text"] = "X"
                button["fg"] = 'red'
                self.clicked = False
            elif button["text"] == " " and not self.clicked and self.count < 9:
                button["text"] = "O"
                button["fg"] = 'green'
                self.clicked = True
            else:
                return

            self.count += 1     # increments count by 1 for each go
            self.checkResult()
            self.updateDisplay(button)

            if self.count == 9 and not self.gameOver:
                self.draw = True
                self.gameOver = True 
                self.updateDisplay(button)

    # checks rows for win
    def checkRows(self):
        winningRows = [
            [(0, 0), (0, 1), (0, 2)],
            [(1, 0), (1, 1), (1, 2)],
            [(2, 0), (2, 1), (2, 2)],
        ]

        for row in winningRows:
            buttonsRow = [self.cells[pos] for pos in row]
            values = [button["text"] for button in buttonsRow]
            if all(value == "X" for value in values):
                self.winnerX = True
                self.gameOver = True
            elif all(value == "O" for value in values):
                self.winnerO = True
                self.gameOver = True

    # checks columns for win
    def checkCols(self):
        winningCols = [
            [(0, 0), (1, 0), (2, 0)],
            [(0, 1), (1, 1), (2, 1)],
            [(0, 2), (1, 2), (2, 2)],
        ]

        for col in winningCols:
            buttonsCol = [self.cells[pos] for pos in col]
            values = [button["text"] for button in buttonsCol]
            if all(value == "X" for value in values):
                self.winnerX = True
                self.gameOver = True
            elif all(value == "O" for value in values):
                self.winnerO = True
                self.gameOver = True

    # checks diagonals for win
    def checkDiags(self):
        winningDiags = [
            [(0, 0), (1, 1), (2, 2)],
            [(0, 2), (1, 1), (2, 0)],
        ]

        for diag in winningDiags:
            buttonsDiag = [self.cells[pos] for pos in diag]
            values = [button["text"] for button in buttonsDiag]
            if all(value == "X" for value in values):
                self.winnerX = True
                self.gameOver = True
            elif all(value == "O" for value in values):
                self.winnerO = True
                self.gameOver = True

    # checks all results for win
    def checkResult(self):
        self.checkRows()
        self.checkCols()
        self.checkDiags()

MyGUI()
