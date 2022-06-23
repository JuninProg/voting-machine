package src.views;
import javax.swing.JButton;
import java.awt.*;

public class ButtonView {
  JButton num1Button;
  JButton num2Button;
  JButton num3Button;
  JButton num4Button;
  JButton num5Button;
  JButton num6Button;
  JButton num7Button;
  JButton num8Button;
  JButton num9Button;
  JButton num0Button;
  JButton confirmButton;
  JButton correctButton;
  JButton blankButton;

  public ButtonView(Integer FRAME_WIDTH, Integer FRAME_HEIGHT) {
    // voting buttons
    Dimension numButtonDimension = new Dimension(55, 40);
    Font numButtonFont = new Font("Arial", Font.PLAIN, 30);

    Integer numButtonSpaceBetween = 40;
    Integer numButtonFirstPosY = 100;
    Integer numButtonSpaceHeight = 20;

    Integer numButtonInitialPosX = FRAME_WIDTH - numButtonDimension.width - 80;
    Integer numButtonMiddlePosX = numButtonInitialPosX - numButtonDimension.width - numButtonSpaceBetween;
    Integer numButtonLastPosX = numButtonMiddlePosX - numButtonDimension.width - numButtonSpaceBetween;

    // first line buttons
    Integer firstLineButtonPosY = numButtonFirstPosY;

    Integer num3PosX = numButtonInitialPosX;
    Integer num3PosY = firstLineButtonPosY;
    this.num3Button = new JButton("3");
    this.num3Button.setFont(numButtonFont);
    this.num3Button.setBounds(num3PosX, num3PosY, numButtonDimension.width, numButtonDimension.height);

    Integer num2PosX = numButtonMiddlePosX;
    Integer num2PosY = firstLineButtonPosY;
    this.num2Button = new JButton("2");
    this.num2Button.setFont(numButtonFont);
    this.num2Button.setBounds(num2PosX, num2PosY, numButtonDimension.width, numButtonDimension.height);

    Integer num1PosX = numButtonLastPosX;
    Integer num1PosY = firstLineButtonPosY;
    this.num1Button = new JButton("1");
    this.num1Button.setFont(numButtonFont);
    this.num1Button.setBounds(num1PosX, num1PosY, numButtonDimension.width, numButtonDimension.height);

    // second line buttons
    Integer secondLineButtonPosY = firstLineButtonPosY + numButtonDimension.height + numButtonSpaceHeight;

    Integer num6PosX = numButtonInitialPosX;
    Integer num6PosY = secondLineButtonPosY;
    this.num6Button = new JButton("6");
    this.num6Button.setFont(numButtonFont);
    this.num6Button.setBounds(num6PosX, num6PosY, numButtonDimension.width, numButtonDimension.height);

    Integer num5PosX = numButtonMiddlePosX;
    Integer num5PosY = secondLineButtonPosY;
    this.num5Button = new JButton("5");
    this.num5Button.setFont(numButtonFont);
    this.num5Button.setBounds(num5PosX, num5PosY, numButtonDimension.width, numButtonDimension.height);

    Integer num4PosX = numButtonLastPosX;
    Integer num4PosY = secondLineButtonPosY;
    this.num4Button = new JButton("4");
    this.num4Button.setFont(numButtonFont);
    this.num4Button.setBounds(num4PosX, num4PosY, numButtonDimension.width, numButtonDimension.height);

    // third line buttons
    Integer thirdLineButtonPosY = secondLineButtonPosY + numButtonDimension.height + numButtonSpaceHeight;

    Integer num9PosX = numButtonInitialPosX;
    Integer num9PosY = thirdLineButtonPosY;
    this.num9Button = new JButton("9");
    this.num9Button.setFont(numButtonFont);
    this.num9Button.setBounds(num9PosX, num9PosY, numButtonDimension.width, numButtonDimension.height);

    Integer num8PosX = numButtonMiddlePosX;
    Integer num8PosY = thirdLineButtonPosY;
    this.num8Button = new JButton("8");
    this.num8Button.setFont(numButtonFont);
    this.num8Button.setBounds(num8PosX, num8PosY, numButtonDimension.width, numButtonDimension.height);

    Integer num7PosX = numButtonLastPosX;
    Integer num7PosY = thirdLineButtonPosY;
    this.num7Button = new JButton("7");
    this.num7Button.setFont(numButtonFont);
    this.num7Button.setBounds(num7PosX, num7PosY, numButtonDimension.width, numButtonDimension.height);

    // fourth line buttons
    Integer fourthLineButtonPosY = thirdLineButtonPosY + numButtonDimension.height + numButtonSpaceHeight;

    Integer num0PosX = numButtonMiddlePosX;
    Integer num0PosY = fourthLineButtonPosY;
    this.num0Button = new JButton("0");
    this.num0Button.setFont(numButtonFont);
    this.num0Button.setBounds(num0PosX, num0PosY, numButtonDimension.width, numButtonDimension.height);

    // fifth line buttons
    Integer actionButtonSpaceHeight = 40;
    Font actionButtonFont = new Font("Arial", Font.PLAIN, 14);
    Integer actionButtonFixedHeight = 30;
    Integer actionButtonSpaceBetween = 20;

    Integer fifthLineButtonPosY = fourthLineButtonPosY + actionButtonFixedHeight + actionButtonSpaceHeight;
    
    // confirm button
    this.confirmButton = new JButton("Confirmar");
    this.confirmButton.setFont(actionButtonFont);
    Integer confirmButtonWidth = this.confirmButton.getPreferredSize().width;

    Integer actionButtonInitialPosX = FRAME_WIDTH - confirmButtonWidth - 46;

    Integer confirmPosX = actionButtonInitialPosX;
    Integer confirmPosY = fifthLineButtonPosY;
    this.confirmButton.setBounds(confirmPosX, confirmPosY, confirmButtonWidth, actionButtonFixedHeight);

    // correct button
    this.correctButton = new JButton("Corrige");
    this.correctButton.setFont(actionButtonFont);
    Integer correctButtonWidth = this.correctButton.getPreferredSize().width;

    Integer correctPosX = confirmPosX - actionButtonSpaceBetween - correctButtonWidth;
    Integer correctPosY = fifthLineButtonPosY;
    this.correctButton.setBounds(correctPosX, correctPosY, correctButtonWidth, actionButtonFixedHeight);

    // blank button
    this.blankButton = new JButton("Branco");
    this.blankButton.setFont(actionButtonFont);
    Integer blankButtonWidth = this.blankButton.getPreferredSize().width;

    Integer blankPosX = correctPosX - actionButtonSpaceBetween - blankButtonWidth;
    Integer blankPosY = fifthLineButtonPosY;
    this.blankButton.setBounds(blankPosX, blankPosY, blankButtonWidth, actionButtonFixedHeight);
  }

  public JButton[] getComponents() {
    JButton[] components = {
      this.num1Button,
      this.num2Button,
      this.num3Button,
      this.num4Button,
      this.num5Button,
      this.num6Button,
      this.num7Button,
      this.num8Button,
      this.num9Button,
      this.num0Button,
      this.confirmButton,
      this.correctButton,
      this.blankButton  
    };
    return components;
  }
}
