import React, {useState} from "react";
import axios from "axios";
import Board from "../../component/board/Board";
import {API_LINK} from "../../constants";
import Button from "@material-ui/core/Button";

export const HomePage = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [chosenPointX, setChosenPointX] = useState();
  const [chosenPointY, setChosenPointY] = useState();

  const [chessBoard, setChessBoard] = useState([]);
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

  const returnProperCellColor = (pointX, pointY) => {
    if (pointY % 2 === 0) {
      if (pointX % 2 === 0) {
        return {backgroundColor: "#efebe9"};
      } else if (pointX % 2 === 1) {
        return {backgroundColor: "#795548"};
      }
    } else if (pointY % 2 === 1) {
      if (pointX % 2 === 0) {
        return {backgroundColor: "#795548"};
      } else if (pointX % 2 === 1) {
        return {backgroundColor: "#efebe9"};
      }
    }
  };

  const onClickChooseCell = (pointX, pointY) => {
    setChosenPointX(pointX);
    setChosenPointY(pointY);
    console.log(pointX, pointY)
  };

  const renderOrderNumber = () => {
    return (
      <div>
        {/*{orderNumber}*/}
      </div>
    );
  };

  const onClickStartAnimation = () => {
    fetchSolution(chosenPointX, chosenPointY);
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <div className="container my-4">
      <Board
        onClickChooseCell={onClickChooseCell}
        renderOrderNumber={renderOrderNumber}
        returnProperCellColor={returnProperCellColor}
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
