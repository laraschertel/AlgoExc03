package AlgoExc03;

import javax.swing.*;
import java.util.LinkedList;

public class CommandFactory {


    private static Stackable<Student> stack = new Stack<Student>();

    static public LinkedList<ICommand> returnsCommandList() {
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(push());
        cmds.add(pop());
        cmds.add(peek());
        cmds.add(checkIfStudentOnStack());
        cmds.add(clearStack());
        cmds.add(printAllStudentsStack());
        cmds.add(stackSize());
        return cmds;
    }


    private static ICommand push() {
        return new ICommand() {

            @Override
            public String execute() {
                String prename = Console.readStringFromStdIn(" Please enter prename: ");
                String surname = Console.readStringFromStdIn(" Please enter surname: ");
                int courseNumber = Console.readIntegerFromStdIn(" Please enter course number: ");
                int matriculationNumber = Console.readIntegerFromStdIn(" Please enter matriculation number: ");

                Student student = new Student(prename, surname, courseNumber, matriculationNumber);

                stack.push(student);

                return System.lineSeparator()  + student + " was pushed" + System.lineSeparator();
            }

            @Override
            public String description() {
                return "Push student to stack.";
            }
        };
    }

    private static ICommand pop() {
        return new ICommand() {

            @Override
            public String execute() {

                if (stack.peek() == null) {
                    return System.lineSeparator() + " There is no student to pop " + System.lineSeparator();
                } else {
                    return System.lineSeparator() + stack.pop() + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return "Pop student from stack.";
            }
        };
    }
    private static ICommand peek() {
        return new ICommand() {

            @Override
            public String execute() {

                if(stack.peek() == null){
                    return System.lineSeparator() + " There is no student to peek "+ System.lineSeparator();
                }else {
                    return System.lineSeparator() + stack.peek() + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return "Peek student.";
            }
        };
    }

    private static ICommand checkIfStudentOnStack() {

        return new ICommand() {

            @Override
            public String execute() {

                if (stack.isEmpty()) {
                    return System.lineSeparator() + "The stack is empty!" + System.lineSeparator();
                } else {
                    return System.lineSeparator() + "There are students on the stack" + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return "Check if students are on the stack.";
            }
        };
    }

    private static ICommand clearStack() {
        return new ICommand() {

            @Override
            public String execute() {
                stack.clear();
                return System.lineSeparator()  + "Stack is clear!" + System.lineSeparator();
            }

            @Override
            public String description() {
                return "Clear stack.";
            }
        };
    }

    private static ICommand printAllStudentsStack() {
        return new ICommand() {

            @Override
            public String execute() {
                if(stack.peek() == null){
                    return System.lineSeparator() + "There are no students to print" + System.lineSeparator();
                }
                else {
                    stack.print();
                    return System.lineSeparator();
                }

            }

            @Override
            public String description() {
                return "Print all students from stack.";
            }
        };
    }

    private static ICommand stackSize() {
        return new ICommand() {

            @Override
            public String execute() {

                return System.lineSeparator() + "There are " + stack.size() + " students on the stack" + System.lineSeparator();
            }

            @Override
            public String description() {
                return "Get size of stack.";
            }
        };
    }


    private static ICommand createExitCommand() {
        return new ICommand() {
            @Override
            public String execute() {
                System.out.println("CLI program closed!");
                System.exit(0);
                return null;
            }

            @Override
            public String description() {
                return "Exit";
            }

        };
    }

}
