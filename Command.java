public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        RemoteControl remoteControl = new RemoteControl();

        Command turnOnCommand = new ProjectorOnCommand(projector);
        Command turnOffCommand = new ProjectorOffCommand(projector);
        Command changeChannelCommand = new ProjectorChangeInput(projector, 2);

        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(changeChannelCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();
    }
}

// Command interface
interface Command {
    void execute();
}


// Receiver class
class Projector {
    public void turnOn() {
        System.out.println("Projector is on");
    }

    public void turnOff() {
        System.out.println("Projector is off");
    }

    public void changeInput(int input) {
        System.out.println("The projector input is changed to HDMI " + input);
    }
}

// Command classes
class ProjectorOnCommand implements Command {
    private Projector projector;

    public ProjectorOnCommand(Projector projector) {
        this.projector = projector;
    }

    public void execute() {
        projector.turnOn();
    }
}

class ProjectorOffCommand implements Command {
    private Projector projector;

    public ProjectorOffCommand(Projector projector) {
        this.projector = projector;
    }

    public void execute() {
        projector.turnOff();
    }
}
class ProjectorChangeInput implements Command {
    private Projector projector;
    private int input;

    public ProjectorChangeInput(Projector projector, int input) {
        this.projector = projector;
        this.input = input;
    }

    public void execute() {
        projector.changeInput(input);
    }
}

// invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
