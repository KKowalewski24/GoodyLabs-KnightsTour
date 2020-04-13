import React, {useState} from "react";
import axios from "axios";
import Board from "../../component/board/Board";
import {API_LINK, BOARD_SIZE} from "../../constants";
import Button from "@material-ui/core/Button";

const fillInitialBoard = () => {
  let board = [];

  for (let i = BOARD_SIZE - 1; i >= 0; i--) {
    for (let j = 0; j < BOARD_SIZE; j++) {
      board.push({"pointX": j, "pointY": i});
    }
  }

  return board;
};

export const HomePage = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [initialBoard, setInitialBoard] = useState(fillInitialBoard);

  const [chosenPointX, setChosenPointX] = useState(null);
  const [chosenPointY, setChosenPointY] = useState(null);

  const [chessBoard, setChessBoard] = useState();
  const [isLoaded, setIsLoaded] = useState(false);
  const [isError, setIsError] = useState(false);

  const fetchSolution = (chosenPointX, chosenPointY) => {
    axios.get(API_LINK, {
      params: {
        pointx: chosenPointX,
        pointy: chosenPointY
      }
    })
      .then((res) => {
        setChessBoard(res.data);
        setIsLoaded(true);
        setIsError(false);
      })
      .catch((err) => {
        setIsLoaded(true);
        setIsError(true);
      });
  };
  const onClickChooseCell = (pointX, pointY) => {
    initialBoard.forEach(it => {
      if (it.hasOwnProperty("orderNumber")) {
        delete it.orderNumber;
      }

      if (it.pointX === pointX && it.pointY === pointY) {
        it.orderNumber = 1;
      }
    })

    setChosenPointX(pointX);
    setChosenPointY(pointY);
  };

  const onClickStartAnimation = () => {
    fetchSolution(chosenPointX, chosenPointY);

  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <>
      {/*todo add progress bar*/}
      <div className="container my-4">

        <Board
          boardData={chessBoard ? chessBoard : initialBoard}
          onClickChooseCell={onClickChooseCell}
        />

        <div className="row justify-content-center mt-2 mb-4">
          <Button onClick={onClickStartAnimation} className="mt-4" variant="contained"
                  color="primary">
            Start Animation
          </Button>
        </div>

      </div>
    </>
  );
};

export default HomePage;
