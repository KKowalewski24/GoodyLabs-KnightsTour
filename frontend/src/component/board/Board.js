import React from "react";
import propTypes from "prop-types";
import Cell from "../cell/Cell";

export const Board = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const renderRow = (pointY) => {
    return (
      <div className="row justify-content-center">
        <Cell
          pointX={0}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={1}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={2}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={3}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={4}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={5}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={6}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
        <Cell
          pointX={7}
          pointY={pointY}
          onClickChooseCell={props.onClickChooseCell}
          renderOrderNumber={props.renderOrderNumber}
        />
      </div>
    );
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <>
      {renderRow(7)}
      {renderRow(6)}
      {renderRow(5)}
      {renderRow(4)}
      {renderRow(3)}
      {renderRow(2)}
      {renderRow(1)}
      {renderRow(0)}
    </>
  );
};

Board.propTypes = {
  onClickChooseCell: propTypes.func.isRequired,
  renderOrderNumber: propTypes.func.isRequired,
};

export default Board;
    