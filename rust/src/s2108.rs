use crate::base::Solution;

impl Solution {
    pub fn first_palindrome(words: Vec<String>) -> String {
        let word = words.iter().find(|s| {
            s.ends_with(
                &s.get(0..(s.len() / 2))
                    .unwrap()
                    .chars()
                    .rev()
                    .collect::<String>(),
            )
        });

        match word {
            Some(x) => x.clone(),
            None => String::new(),
        }
    }
}
