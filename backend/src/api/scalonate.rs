use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::cartesian_plane::scalonate::scalonate as core_scalonate;

use super::serializable_cartesian_point::SerializableCartesianPoint;

#[wasm_bindgen]
extern "C" {
    // Use `js_namespace` here to bind `console.log(..)` instead of just
    // `log(..)`
    #[wasm_bindgen(js_namespace = console)]
    fn log(s: &str);

    // The `console.log` is quite polymorphic, so we can bind it with multiple
    // signatures. Note that we need to use `js_name` to ensure we always call
    // `log` in JS.
    #[wasm_bindgen(js_namespace = console, js_name = log)]
    fn log_u32(a: u32);

    // Multiple arguments too!
    #[wasm_bindgen(js_namespace = console, js_name = log)]
    fn log_many(a: &str, b: &str);
}

macro_rules! console_log {
    // Note that this is using the `log` function imported above during
    // `bare_bones`
    ($($t:tt)*) => (log(&format_args!($($t)*).to_string()))
}

#[derive(Deserialize)]
pub struct Arguments {
    pub point: SerializableCartesianPoint,
    pub factor: SerializableCartesianPoint,
}

#[wasm_bindgen]
pub fn scalonate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: Arguments = serde_wasm_bindgen::from_value(val)?;

    let big_float: f64 = 1.123456789012345678901234567890123456789012345678901234567890123;
    console_log!("original: {}", args.factor.x);
    console_log!("f parse: {}", args.factor.x.parse::<f64>().unwrap());
    console_log!(
        "back to str: {}",
        args.factor.x.parse::<f64>().unwrap().to_string()
    );
    console_log!("big_float: {}", big_float);

    let return_value = core_scalonate(
        CartesianPoint {
            x: args.point.x.parse().unwrap(),
            y: args.point.y.parse().unwrap(),
        },
        CartesianPoint {
            x: args.factor.x.parse().unwrap(),
            y: args.factor.y.parse().unwrap(),
        },
    );
    let x = return_value.x;
    let y = return_value.y;
    let serializable = SerializableCartesianPoint {
        x: format!("{x:.64}"),
        y: format!("{y:.64}"),
    };
    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
