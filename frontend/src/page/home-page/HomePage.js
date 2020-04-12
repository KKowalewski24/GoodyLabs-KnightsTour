import React, {useState} from "react";
import axios from "axios";
import Board from "../../component/board/Board";
import {GlobalStyles} from "../../main/GlobalStyles";
import {API_LINK} from "../../constants";
import Button from "@material-ui/core/Button";

export const HomePage = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [chosenPointX, setChosenPointX] = useState();
  const [chosenPointY, setChosenPointY] = useState();

  const [chessBoard, setChessBoard] = useState([]);
  const [isLoaded, setIsLoaded] = useState(false);
  const [isError, setIsError] = useState(false);
  const globalStyles = GlobalStyles();

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
    fetchSolution();
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <div className="container my-2">
      <Board
        onClickChooseCell={onClickChooseCell}
        renderOrderNumber={renderOrderNumber}
      />

      <div className="row justify-content-center m-5">
        {/*<button className={"btn " + globalStyles.materialBlueBackground}*/}
        {/*        onClick={onClickStartAnimation}>*/}
        {/*  Start Animation*/}
        {/*</button>*/}
        <Button onClick={onClickStartAnimation} className="mt-4" variant="contained" color="primary">
          Start Animation
        </Button>
      </div>

    </div>
  );
};

export default HomePage;
