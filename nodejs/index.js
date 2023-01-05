const express = require('express')
const app = express()
const port = 3000


app.get('/', (req, res) => {
  const { input } = req.query
  let hash = 0,
  i, chr;
  if (input.length === 0) return 0;
  for (i = 0; i < input.length; i++) {
    chr = input.charCodeAt(i);
    hash = ((hash << 5) - hash) + chr;
    hash |= 0; // Convert to 32bit integer
  }
  
  
  console.log(String(input), hash);
  res.send(String(hash), 200);
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
