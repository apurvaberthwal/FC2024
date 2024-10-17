const fs = require('fs');
fs.writeFile('newfile.txt', 'This is the content of the new file !!!!', (err) => {
  if (err) {
    console.error('Error creating file:', err);
    return;
  }
  console.log('File created successfully and data added!');
});
