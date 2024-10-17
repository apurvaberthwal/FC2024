const http = require('http');
http.createServer((req, res) => {
  res.writeHead(200, {'Content-Type': 'text/html'});
  const currentDate = new Date();
  res.end(`
    <!DOCTYPE html>
    <html>
    <head>
      <title>Current Date and Time</title>
      <style>
        body {
          font-family: Arial, sans-serif;
          padding: 20px;
          background-color: #f0f0f0;
        }
        .date {
          background-color: #fff;
          padding: 20px;
          border-radius: 5px;
        }
      </style>
    </head>
    <body>
      <div class="date">
        <h1>Current Date and Time:</h1>
        <p>${currentDate}</p>
      </div>
    </body>
    </html>
  `);
}).listen(3000, () => {
  console.log('Server running at http://localhost:3000');
});