import React, {useState} from "react";
import axios from "axios";
import Board from "../../component/board/Board";
import {API_LINK, BOARD_SIZE} from "../../constants";
import Button from "@material-ui/core/Button";

const fillInitialBoard = () => {
  let board = [];

  for (let i = 0; i < BOARD_SIZE; i++) {
    for (let j = 0; j < BOARD_SIZE; j++) {
      board.push({"pointX": j, "pointY": i});
    }
  }

  return board;
};

export const HomePage = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [chosenPointX, setChosenPointX] = useState(null);
  const [chosenPointY, setChosenPointY] = useState(null);
  const [initialBoard] = useState(fillInitialBoard);
  const [chessBoard, setChessBoard] = useState();

  const fetchSolution = (chosenPointX, chosenPointY) => {
    axios.get(API_LINK, {
      params: {
        pointx: chosenPointX,
        pointy: chosenPointY
      }
    })
      .then((res) => {
        setChessBoard(res.data.chestBoard);
      })
      .catch((err) => {
        console.log(err);
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
    if (!(chosenPointX === null && chosenPointY === null)) {
      fetchSolution(chosenPointX, chosenPointY);
    } else {
      alert("Initial Cell has not been chosen");
    }
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
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
  );
};

export default HomePage;
