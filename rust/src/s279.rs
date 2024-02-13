use crate::base::Solution;
use std::io::{self, Write};

pub struct ArrayQueue {
    head: usize,
    tail: usize,
    array: [i16; MAX_SIZE],
}

impl ArrayQueue {
    pub fn enqueue(&mut self, value: i16) {
        self.array[self.tail] = value;
        self.tail += 1;
    }
    pub fn dequeue(&mut self) -> i16 {
        let tmp = self.array[self.head];
        self.head += 1;
        tmp
    }
    pub fn empty(&mut self) {
        self.head = 0;
        self.tail = 0;
        self.array.fill(0);
    }
}

static mut VISITED: [i16; MAX_SIZE] = [0; MAX_SIZE];
static mut QUEUE: ArrayQueue = ArrayQueue {
    head: 0,
    tail: 0,
    array: [0; MAX_SIZE],
};

const MAX_SIZE: usize = 10001;

impl Solution {
    /**
     * Vamos a implementar un BFS de tal modo que
     * iniciando en n, vayamos restando el mayor numero
     * hasta llegar al 0
     */
    pub fn num_squares(n: i32) -> i32 {
        let n = n as i16;

        /* Comprobamos si n ya es un cuadrado perfecto */
        if n == ((n as f32).sqrt() as i16).pow(2) {
            return 1;
        }

        unsafe {
            VISITED.fill(0);
            VISITED[n as usize] = 1;
            QUEUE.empty();
            QUEUE.enqueue(n);
        }

        loop {
            let node: i16 = unsafe { QUEUE.dequeue() };
            let sqrt: i16 = (node as f32).sqrt() as i16;

            for i in (1..=sqrt).rev() {
                let new_n = node - i.pow(2);

                /* Comprobamos si new_n ya es un cuadrado perfecto */
                if unsafe { VISITED[new_n as usize] } == 0 {
                    if new_n == ((new_n as f32).sqrt() as i16).pow(2) {
                        return unsafe { VISITED[node as usize] + 1 } as i32;
                    } else {
                        unsafe {
                            VISITED[new_n as usize] = VISITED[node as usize] + 1;
                            QUEUE.enqueue(new_n);
                        }
                    }
                }
            }
        }
    }
}
/**
 * Leetcode: 279
 *
 * Resuelto mediante BFS
 */
pub fn s279() {
    loop {
        let mut input = String::new();
        print!("Number: ");
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut input).unwrap();

        let num: i32 = match input.trim().parse() {
            Ok(val) => val,
            Err(_) => {
                println!("Invalid Number");
                continue;
            }
        };

        println!("{}", Solution::num_squares(num));
    }
}
