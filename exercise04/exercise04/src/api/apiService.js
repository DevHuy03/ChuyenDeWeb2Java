import axios from "axios";
let API_URL = "http://localhost:8080/api";

export async function callApi(endpoint, method = "GET", body) {
  try {
    return await axios({
      method,
      url: `${API_URL}/${endpoint}`,
      data: body,
    });
  } catch (e) {
    console.log(e);
  }
}
export function GET_ALL_PRODUCTS(endpoint) {
  return callApi(endpoint, "GET");
}
export function GET_PRODUCT_ID(endpoint, id) {
  return callApi(endpoint + "/" + id, "GET");
}
export function POST_ADD_PRODUCTS(endpoint, data) {
  return callApi(endpoint, "POST", data);
}
export function PUT_EDIT_PRODUCTS(endpoint, data) {
  return callApi(endpoint, "PUT", data);
}
export function DELETE_PRODUCT_ID(endpoint) {
  return callApi(endpoint, "DELETE");
}
