import React, {useEffect, useState} from "react";
import axios from "axios";
import Board from "../../component/board/Board";
import FetchDataController from "../../component/util/fetch-data-controller/FetchDataController";
import {GlobalStyles} from "../../main/GlobalStyles";
import {API_LINK, PATH_HOME} from "../../constants";

export const HomePage = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [pointX, setPointX] = useState();
  const [pointY, setPointY] = useState();

  const [chessBoard, setChessBoard] = useState([]);
  const [isLoaded, setIsLoaded] = useState(false);
  const [isError, setIsError] = useState(false);
  const globalStyles = GlobalStyles();

  const onClickGetSolution = () => {
    axios.get(API_LINK, {
      params: {
        pointx: pointX,
        pointy: pointY
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

  /*------------------------ RETURN REGION ------------------------*/
  return (
    // <FetchDataController
    //   isLoaded={isLoaded}
    //   isError={isError}
    //   errorMessageObject={{
    //     message: "Error during loading",
    //     redirectPath: PATH_HOME,
    //     redirectMessage: "Refresh Page",
    //     styles: globalStyles.materialBlueFont,
    //   }}
    // >
    <div className="container">
      <Board/>

      <div className="row justify-content-center">
        <button className={"btn " + globalStyles.materialBlueBackground}
          onClick={onClickGetSolution}>
          Start Animation
        </button>
      </div>

    </div>
    // </FetchDataController>
  );
};

export default HomePage;
