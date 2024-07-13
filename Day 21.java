// Day 21 of 30 Days Leetcode.

// Problem Number 2751: Robot Collisions.

class Robot {
  int index, position, health;
  char direction;

  Robot(int index, int position, int health, char direction) {
    this.index = index;
    this.position = position;
    this.health = health;
    this.direction = direction;
  }
}

class Solution {
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    List<Integer> ans = new ArrayList<>();
    List<Robot> stack = new ArrayList<>();
    Robot[] robots = IntStream.range(0, positions.length)
                              .mapToObj(i -> new Robot(i, positions[i], healths[i], directions.charAt(i)))
                              .sorted(Comparator.comparingInt(r -> r.position))
                              .toArray(Robot[]::new);

    for (Robot robot : robots) {
      if (robot.direction == 'R') {
        stack.add(robot);
      } else {
        while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
          Robot rightRobot = stack.get(stack.size() - 1);
          if (rightRobot.health == robot.health) {
            stack.remove(stack.size() - 1);
            robot.health = 0;
          } else if (rightRobot.health < robot.health) {
            stack.remove(stack.size() - 1);
            robot.health--;
          } else {
            rightRobot.health--;
            robot.health = 0;
          }
        }
        if (robot.health > 0) stack.add(robot);
      }
    }

    stack.stream().sorted(Comparator.comparingInt(r -> r.index)).forEach(r -> ans.add(r.health));

    return ans;
  }
}
