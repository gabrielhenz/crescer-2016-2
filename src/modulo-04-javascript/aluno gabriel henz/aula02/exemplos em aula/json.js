var str = '{"nome:""Oi","idade":21}';
console.log(typeof str);
var objStr = JSON.parse(str);
console.log(objStr);

JSON.stringfy(objStr);
