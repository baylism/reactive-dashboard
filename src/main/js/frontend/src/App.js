import React, { Component } from 'react';
import './App.css';
import MovingChart from "./components/MovingChart";
import WebsocketChart from "./components/WebsocketChart";

class App extends Component {
  render() {
    return (
      <div className="App">


          <h1>Dashboard</h1>


          <div className={"feature-graph"}>
              <MovingChart title={"Top Graph"}/>
          </div>

          <div className={"middle-container"}>
              <MovingChart title={"Middle Graph"}/>
              <MovingChart title={"Middle Graph"}/>
              <MovingChart title={"Middle Graph"}/>
              <MovingChart title={"Middle Graph"}/>

              {/*<WebsocketChart title={"Temperature"}/>*/}
              {/*<WebsocketChart title={"Temperature"}/>*/}
          </div>

          <h2>Analysis</h2>


          <div className={"analysis"}>

              <div className={"lower-graph"}>
                  <MovingChart title={"Middle Graph"} smallTitle={true}/>
              </div>

              <div className={"lower-text"}>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                  fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt
                  in culpa qui officia deserunt mollit anim id est laborum.
              </div>

              <div className={"lower-graph"}>
                  <MovingChart title={"Middle Graph"} smallTitle={true}/>
              </div>

              <div className={"lower-text"}>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                  fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt
                  in culpa qui officia deserunt mollit anim id est laborum.
              </div>

          </div>






          {/*<div className={"topleft"}>*/}
              {/*<WebsocketChart title={"Temperature"}/>*/}
          {/*</div>*/}


      </div>
    );
  }
}

export default App;
