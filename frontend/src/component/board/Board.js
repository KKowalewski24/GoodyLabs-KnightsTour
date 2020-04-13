import React from "react";
import propTypes from "prop-types";
import Cell from "../cell/Cell";
import {BOARD_SIZE} from "../../constants";

export const Board = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
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

  const makeRow = (row, index) => {
    return (
      <div key={index} className="d-flex flex-row justify-content-center">
        {
          row.map((it, index) => {
            return (
              <Cell
                key={index}
                pointX={it.pointX}
                pointY={it.pointY}
                cellColor={returnProperCellColor(it.pointX, it.pointY)}
                cellValue={it.orderNumber ? it.orderNumber : ""}
                onClickChooseCell={props.onClickChooseCell}
              />
            );
          })
        }
      </div>
    );
  };

  const makeBoard = () => {
    let rowArray = [];
    let boardArray = [];

    props.boardData.forEach((it, index) => {
      rowArray.push(it);

      if (rowArray.length === BOARD_SIZE) {
        boardArray.push(makeRow(rowArray, index));
        rowArray = [];
      }
    })

    return boardArray;
  };

  /*------------------------ RETURN REGION ------------------------*/
  return makeBoard();

};

Board.propTypes = {
  boardData: propTypes.array.isRequired,
  onClickChooseCell: propTypes.func.isRequired,
};

export default Board;
    