use crate::core::precise_decimal::PreciseDecimal;

#[derive(Debug)]
pub struct PolarPoint {
    pub r: PreciseDecimal,
    pub a: PreciseDecimal,
}

impl PartialEq for PolarPoint {
    fn eq(&self, other: &Self) -> bool {
        self.r == other.r && self.a == self.a
    }
}
