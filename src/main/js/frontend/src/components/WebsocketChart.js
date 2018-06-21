import React, {Component} from 'react';
import {Line} from "react-chartjs-2";
import moment from "moment";

/**
 * TODO pan and zoom:
 * https://jsfiddle.net/jyougo/hyyw0cyb/
 * or http://jsfiddle.net/jmpxgufu/
 * or http://jsfiddle.net/mbhavfwm/
 */
class MovingChart extends Component {
    constructor(props) {
        super(props);

        this.state = {
            graphdata: {},
            socket: WebSocket
        };
        this.updateGraph = this.updateGraph.bind(this);
    }

    componentDidMount() {
        this.setState({
            graphdata: {
                labels: Array(6).fill(''),
                datasets: [
                    {
                        label: 'My First dataset',
                        fill: false,
                        lineTension: 0.2,
                        backgroundColor: "rgba(75,192,192,0.4)",
                        borderColor: "rgba(75,192,192,1)",
                        borderCapStyle: 'butt',
                        borderDash: [],
                        borderDashOffset: 0.0,
                        borderWidth: 1,
                        borderJoinStyle: 'miter',
                        pointBorderColor: "rgba(75,192,192,1)",
                        pointBackgroundColor: "#fff",
                        pointBorderWidth: 1,
                        pointHoverRadius: 5,
                        pointHoverBackgroundColor: "rgba(75,192,192,1)",
                        pointHoverBorderColor: "rgba(220,220,220,1)",
                        pointHoverBorderWidth: 2,
                        pointRadius: 0,
                        pointHitRadius: 10,
                        data: Array(6).fill(null)
                    }
                ]
            }
        });

        this.socket = new WebSocket("ws://localhost:8080/websocket/temps");

        this.socket.onmessage = (event) => {
            console.log(event.data);
            this.updateGraph(event.data);
        };
    }

    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    static timeAxis(interval){
        let now = new Date();
        let nowSecs = moment(now).format("s");

        if (nowSecs % interval === 0) {
            return nowSecs === '0' ? moment(now).format("mm:ss") : moment(now).format(":ss");
        } else {
            return '';
        }
    }

    updateGraph(newValue) {
        this.setState((prevState) => {
            // make copies
            const datasetsCopy = prevState.graphdata.datasets.slice(0);
            const dataCopy = datasetsCopy[0].data.slice(0);
            const labelsCopy = prevState.graphdata.labels;

            // update data
            dataCopy.push(newValue);
            dataCopy.shift();

            // update labels
            labelsCopy.push(MovingChart.timeAxis(3));
            labelsCopy.shift();

            // combine data and labels
            datasetsCopy[0].data = dataCopy;

            return {
                graphdata:
                    Object.assign(
                        {},
                        prevState.datasets,
                        {
                            datasets: datasetsCopy,
                            labels: labelsCopy
                        })
            }
        });
    }

    static options() {
        return {
            showLines: true,
            animation: false,
            legend: {
                display: false
            },
            scales: {
                yAxes: [{
                    ticks: {
                        max: 100,
                        min: 0,
                        stepSize: 50
                    },
                    gridLines: {
                        drawTicks: false
                    }
                }],
                xAxes: [{
                    gridLines: {
                        display: true,
                        drawTicks: false
                    },
                    ticks: {
                        fontSize: 10,
                        maxRotation: 0,
                        autoSkip: false,
                    }
                }]
            },
        };
    }


    render() {
        return (
            <div className="MovingChart">
                <h2>{this.props.title}</h2>

                <Line
                    data={this.state.graphdata}
                    options={MovingChart.options()}
                />


            </div>
        );
    }
}

export default MovingChart;
