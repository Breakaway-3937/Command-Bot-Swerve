# Swerve Drive Starter Code

**Welcome to the world of swerve!** 🎉

A clean, educational starter project for command-based swerve drive robots using Java and TalonFX motor controllers. Built by the Breakaway 3937 programming team to help other teams learn fundamental programming concepts and experience the magic of swerve drive.

## ✨ Features

- 🎮 Command-based robot architecture
- 🔄 Four-wheel swerve drive implementation
- ⚡ TalonFX motor controller integration
- 🧭 Field-centric drive mode
- 📚 Clear code structure for educational purposes

## 🛠️ Requirements

### Software
- **Java Development Kit (JDK)** - Version 17 or higher
- **WPILib** - Latest FRC season release
- **CTRE-Phoenix** - Latest VenderDep
- **WPILib-New-Commands** - Latest VenderDep

### Hardware
- TalonFX motor controllers (8 total - 2 per swerve module)
- 4 swerve modules with encoders
- RoboRIO
- NavX or Pigeon (Pigeon recommended)

## 🚀 Getting Started

### Configuration

Before unleashing your robot onto the field, you'll need to generate some values in the `TunerConstants.java` file:

- Get Pheniox Tuner X from the Web Store
- Navigate to 'Mechanisms'
- Follow the steps to generate the TunerConstants file

### Deployment

1. Connect to your robot via USB or WiFi
2. Press `F5` or use the WPILib command palette to deploy code
3. Enable the robot in the Driver Station
4. Experience the swerve magic! ✨

## 📁 Project Structure

```
src/main/java/frc/robot/
├── subsystems/         # The robot's building blocks
  ├── Swerve.java       # The file of Magic
├── Constants.java      # Your robot's personality traits
├── Main.java           # The beginning of it all
├── Robot.java          # The heart of the robot
└── RobotContainer.java # Where everything comes together
```

## 🎮 Basic Usage

### Driving the Robot

The default configuration uses:
- **Left Joystick**: Translation (forward/backward, left/right) - Move like a drone!
- **Right Joystick X-axis**: Rotation - Spin to win!
- **Re-seed Roatation**: Reset your robots heading.

## 📖 Learning Resources

This starter code is designed to teach:
- 🎯 Object-oriented programming in Java (classes, objects, and all that jazz)
- 🏗️ Command-based robot architecture (organized code = happy programmers)
- 🧮 Swerve drive kinematics (the math behind the magic)
- 🎛️ Motor control and sensor integration (making hardware and software play nice)
- 🌿 Git version control and collaboration (never lose your code again!)

## 🤝 Contributing

This is an educational project, and we'd love your input! Feel free to:
- 🍴 Fork and modify for your team's needs
- 🐛 Submit issues for bugs or unclear documentation
- 💡 Propose improvements via pull requests
- 🌟 Star the repo if it helps your team!

## 💬 Support

If you're using this code for educational purposes and have questions:
1. Check the code comments for explanations (we wrote a lot of them!)
2. Review WPILib documentation (your encyclopedia)
3. Open an issue on this repository (we're here to help!)
4. Reach out to the FRC community forums (we're all in this together!)

## 📜 License

This project is released under the MIT License. Feel free to use, modify, and distribute for educational purposes. Share the swerve love! ❤️

## 🙏 Acknowledgments

**Created with ❤️ by the Breakaway 3937 Programming Team**

We built this starter code to help FRC teams learn swerve drive programming and level up their computer skills. Our goal is to make swerve more accessible and less intimidating for teams everywhere!

Special thanks to the FRC community for their educational resources, endless support, and for making robotics the most fun you can have with a bunch of metal and code.

---

**Pro tip**: This is starter code intended for learning. Teams should test thoroughly, add safety features, and maybe not run at full speed on the first try. We believe in you, but we also believe in practicing in an open space!
