import React, { Component } from 'react';
import './App.css';
import MovingChart from "./components/MovingChart";
import WebsocketChart from "./components/WebsocketChart";

class App extends Component {
  render() {
    return (
      <div className="App">

          <div className={"topleft"}>
              <WebsocketChart title={"Temperature"}/>
          </div>

          <div className={"topright"}>
              <MovingChart title={"Random Values"}/>

          </div>

      </div>
    );
  }
}

export default App;
