const fs = require('fs');

fs.readFile('date.js', 'utf8', (err, data) => {
  if (err) {
    console.error('Error reading file:', err);
    return;
  }
  console.log('File Contents:', data);
});
