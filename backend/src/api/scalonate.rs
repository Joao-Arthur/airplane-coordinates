use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

#[wasm_bindgen]
pub fn translate(val: &JsValue) -> JsValue {
    return point + factor;
}
