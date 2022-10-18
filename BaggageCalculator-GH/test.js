import axios from "axios";

let base = '';
export const postRequest = (url, parmas) => {
  return axios({
    method: 'post',
    url: `${base}${url}`,
    data: parmas
  })
}

// test('foo', t => {
//   t.pass();
// });

// test('bar', async t => {
//   const bar = Promise.resolve('bar');
//   t.is(await bar, 'bar');
// });
