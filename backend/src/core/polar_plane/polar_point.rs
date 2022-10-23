use crate::core::precise_decimal::PreciseDecimal;

#[derive(Debug)]
pub struct PolarPoint {
    pub r: f64,
    pub a: f64,
}

impl PartialEq for PolarPoint {
    fn eq(&self, other: &Self) -> bool {
        self.r == other.r && self.a == self.a
    }
}

#[derive(Debug)]
pub struct NewPolarPoint {
    pub r: PreciseDecimal,
    pub a: PreciseDecimal,
}

impl PartialEq for NewPolarPoint {
    fn eq(&self, other: &Self) -> bool {
        self.r == other.r && self.a == self.a
    }
}
