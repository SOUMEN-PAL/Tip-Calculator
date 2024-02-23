# Tip Calculator App

This Android application, built using Kotlin and Jetpack Compose, allows users to calculate tips based on the input amount and selected tip percentage. Additionally, it provides the option to split the total bill among multiple individuals.

## Features

- **Tip Calculation**: Users can input the bill amount and select the desired tip percentage using a slider.
- **Split Bill**: Users can specify the number of people to split the bill among.
- **Dynamic UI**: Developed using Jetpack Compose, providing a modern and flexible user interface.
- **Responsive Design**: The UI adjusts dynamically to different screen sizes and orientations.

## Video Demo

You can view a demo of the application in action by watching the following video: [Demo Video](https://github.com/SOUMEN-PAL/Tip-Calculator/assets/112452467/11c6154a-c378-4ea3-af3e-869c6bd420c6)


## Screenshots

<div style="display:flex;justify-content:center;">
    <img src="https://github.com/SOUMEN-PAL/Tip-Calculator/assets/112452467/f3d2b403-61be-4e88-a985-d972f9b0c9b1" alt="Screenshot 1" width="45%">
    <img src="https://github.com/SOUMEN-PAL/Tip-Calculator/assets/112452467/2144d9f4-d4e6-4bb2-933a-07c0539e30dd" alt="Screenshot 2" width="45%">
</div>


## Installation

To run the application locally, follow these steps:

1. Clone this repository: `git clone https://github.com/SOUMEN-PAL/Tip-Calculator.git`
2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.

## Usage

1. Launch the application on your Android device.
2. Input the bill amount.
3. Adjust the tip percentage using the slider.
4. Optionally, specify the number of people to split the bill among.
5. View the calculated tip amount and total bill, including the split amount per person.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/new-feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature/new-feature`).
6. Create a new Pull Request.



## Acknowledgements

- Thank you to the Jetpack Compose and Kotlin communities for their valuable resources and support.

## MVVM Implementation

This application follows the MVVM (Model-View-ViewModel) architecture pattern. Here's how it's implemented:

### Model

The `JetTipModel` class represents the data and business logic of the application. It contains properties such as total per person, total amount, split number, tip, and tip percentage.

### Repository

The `JetTipRepository` class manages the data operations. It initializes the `JetTipModel` and provides methods to access and modify its data.

### ViewModel

The `JetTipViewModel` class serves as a bridge between the UI (View) and the data (Model). It holds the UI-related data and provides methods for the View to interact with the data. It communicates with the `JetTipRepository` to fetch and update data.

The ViewModel exposes mutable state variables for total per person, total amount, split number, tip, and tip percentage. These variables are observed by the View (UI) components to reflect changes in the data.

By separating concerns and adhering to the MVVM architecture, the application becomes more modular, testable, and maintainable.
