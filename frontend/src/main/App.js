import React, {useState} from "react";
import {BrowserRouter} from "react-router-dom";
import Routes from "./Routes";
import {createMuiTheme} from "@material-ui/core";
import {ThemeProvider} from "@material-ui/styles";
import CssBaseline from "@material-ui/core/CssBaseline";
import Navbar from "../component/navbar/Navbar";

export const App = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [isDarkMode, setIsDarkMode] = useState(true);

  const darkTheme = createMuiTheme({
    palette: {
      type: isDarkMode ? "dark" : "light",
      primary: {
        main: "#2196f3",
      },
    },
  });

  const handleDarkMode = () => {
    setIsDarkMode(!isDarkMode);
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline/>
      <BrowserRouter>
        <Navbar
          msg="Knight's tour"
          isDarkMode={isDarkMode}
          handleDarkMode={handleDarkMode}
        >
          <Routes/>
        </Navbar>
      </BrowserRouter>
    </ThemeProvider>
  );
};

export default App;
    