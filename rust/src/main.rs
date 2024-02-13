use crate::base::Solution;

pub mod base;
mod s2108;
mod s279;

fn main() {
    println!("Hello, World!");
    let sol = Solution::first_palindrome(
        ["abc", "car", "ada", "racecar", "cool", "papa"]
            .iter()
            .map(|s| s.to_string())
            .collect(),
    );
    println!("Sol: {sol}");
}
