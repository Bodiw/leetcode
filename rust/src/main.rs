use std::collections::VecDeque;
struct Solution {}
struct Node {
    number: i32,
    visited: i32,
}

/* const _POWS: [i32; 101] = {
    let mut arr: [i32; 101] = [0; 101];
    let mut i = 1;
    while i < 101 {
        arr[i] = (i as i32).pow(2);
        i += 1;
    }
    arr
};
 */
impl Solution {
    /**
     * Vamos a implementar un BFS de tal modo que
     * iniciando en n, vayamos restando el mayor numero
     * hasta llegar al 0
     */
    pub fn num_squares(n: i32) -> i32 {
        let mut queue: VecDeque<Node> = VecDeque::new();

        queue.push_back(Node {
            number: n,
            visited: 1,
        });

        while !queue.is_empty() {
            let node: Node = queue.pop_front().unwrap();
            let sqrt: i32 = (node.number as f32).sqrt() as i32;
            let diff = node.number - sqrt.pow(2);

            if diff == 0 {
                return node.visited;
            } else if diff > 0 {
                for _i in (1..=sqrt).rev() {
                    let new_n = node.number - sqrt.pow(2);

                    if new_n > 0 {
                        queue.push_back(Node {
                            number: new_n,
                            visited: node.visited + 1,
                        })
                    }
                }
            }
        }
        0
    }
}
/**
 * Leetcode: 279
 *
 * Resuelto mediante BFS
 */
fn main() {
    loop {
        let mut input = String::new();
        print!("Please enter a number: ");
        io::stdout().flush().unwrap(); // Make sure the prompt is immediately displayed
        io::stdin().read_line(&mut input).unwrap();

        let num: i32 = match input.trim().parse() {
            Ok(val) => val,
            Err(_) => {
                println!("This is not a valid number. Please try again.");
                continue;
            }
        };

        println!("You entered: {}", num);
        // Add a condition here to break the loop if necessary
    }
}
