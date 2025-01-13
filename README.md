1) The code now includes logic for all three chess pieces: Pawn, King, and Queen.
2) The "getPieceMoves" method differentiates the piece type and generates moves accordingly.
3) For the Pawn, it calculates a forward move.
4) For the King, it considers all neighboring cells for possible moves.
5) The "getQueenMoves" method was reused for the Queen's diagonal, horizontal, and vertical moves.
6) The "isValid" method checks if a calculated row and column are within the bounds of the chessboard.
7) The output displays the possible moves for the specified chess piece at the given position.
8) Testing samples -
      i)  Input: King, D5
          Output - C4, C5, C6, D4, D6, E4, E5, E6
      ii) Input: Queen, E4
          Output - A4, B4, C4, D4, F4, G4, H4, E1, E2, E3, E5, E6, E7, E8, A8, B7, C6, D5, F3, G2, H1, B1, C2, D3, F5, G6, H7
      iii) Input: Pawn, B5
           Output - B5
         
