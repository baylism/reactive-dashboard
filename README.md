# reactive-dashboard 

A basic dashboard using Spring WebFlux and React.

This is a work in progress and currently only displays a couple of graphs with random data. 

## TODO
1. [x] Set up development environment. 
2. Create a single-page react application with a line graph component that can be updated as new data is streamed in. [x]
3. Create a Spring WebFlux backend and that serves the React application. [x]
4. Create some sample data streams (probably random numbers) which will be displayed on the dashboard. [x]
5. Create a Webflux websockets API to which the clients can subscribe. [x]
6. Publish the data streams on the API and visualise in the react graphs. [x]
7. More components for different graph types (bar, doughnut etc.)
8. Build out React app with better structure, error handling etc.
9. Improve CSS
10. Add Spring security, optimise backend (connection sharing?)


