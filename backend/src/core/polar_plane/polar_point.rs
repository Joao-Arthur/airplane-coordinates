#[derive(Debug)]
pub struct PolarPoint {
    pub r: f64,
    pub a: f64,
}

impl PartialEq for PolarPoint {
    fn eq(&self, other: &Self) -> bool {
        return self.r == other.r && self.a == self.a;
    }
}

#[derive(Debug)]
pub struct NewPolarPoint {
    pub r: String,
    pub a: String,
}

impl PartialEq for NewPolarPoint {
    fn eq(&self, other: &Self) -> bool {
        return self.r == other.r && self.a == self.a;
    }
}
