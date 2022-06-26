package src.views;
import javax.swing.JButton;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

public class ButtonView {

  public enum buttonTypes {
    num0,
    num1,
    num2,
    num3,
    num4,
    num5,
    num6,
    num7,
    num8,
    num9,
    confirm,
    correct,
    blank,
    score,
    options
  }

  public HashMap<buttonTypes, JButton> components = new HashMap<buttonTypes, JButton>();

  public Collection<JButton> getComponents() {
    return this.components.values();
  }

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
    JButton num3Button = new JButton("3");
    num3Button.setFont(numButtonFont);
    num3Button.setBounds(num3PosX, num3PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num3, num3Button);

    Integer num2PosX = numButtonMiddlePosX;
    Integer num2PosY = firstLineButtonPosY;
    JButton num2Button = new JButton("2");
    num2Button.setFont(numButtonFont);
    num2Button.setBounds(num2PosX, num2PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num2, num2Button);

    Integer num1PosX = numButtonLastPosX;
    Integer num1PosY = firstLineButtonPosY;
    JButton num1Button = new JButton("1");
    num1Button.setFont(numButtonFont);
    num1Button.setBounds(num1PosX, num1PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num1, num1Button);

    // second line buttons
    Integer secondLineButtonPosY = firstLineButtonPosY + numButtonDimension.height + numButtonSpaceHeight;

    Integer num6PosX = numButtonInitialPosX;
    Integer num6PosY = secondLineButtonPosY;
    JButton num6Button = new JButton("6");
    num6Button.setFont(numButtonFont);
    num6Button.setBounds(num6PosX, num6PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num6, num6Button);

    Integer num5PosX = numButtonMiddlePosX;
    Integer num5PosY = secondLineButtonPosY;
    JButton num5Button = new JButton("5");
    num5Button.setFont(numButtonFont);
    num5Button.setBounds(num5PosX, num5PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num5, num5Button);

    Integer num4PosX = numButtonLastPosX;
    Integer num4PosY = secondLineButtonPosY;
    JButton num4Button = new JButton("4");
    num4Button.setFont(numButtonFont);
    num4Button.setBounds(num4PosX, num4PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num4, num4Button);

    // third line buttons
    Integer thirdLineButtonPosY = secondLineButtonPosY + numButtonDimension.height + numButtonSpaceHeight;

    Integer num9PosX = numButtonInitialPosX;
    Integer num9PosY = thirdLineButtonPosY;
    JButton num9Button = new JButton("9");
    num9Button.setFont(numButtonFont);
    num9Button.setBounds(num9PosX, num9PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num9, num9Button);

    Integer num8PosX = numButtonMiddlePosX;
    Integer num8PosY = thirdLineButtonPosY;
    JButton num8Button = new JButton("8");
    num8Button.setFont(numButtonFont);
    num8Button.setBounds(num8PosX, num8PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num8, num8Button);

    Integer num7PosX = numButtonLastPosX;
    Integer num7PosY = thirdLineButtonPosY;
    JButton num7Button = new JButton("7");
    num7Button.setFont(numButtonFont);
    num7Button.setBounds(num7PosX, num7PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num7, num7Button);

    // fourth line buttons
    Integer fourthLineButtonPosY = thirdLineButtonPosY + numButtonDimension.height + numButtonSpaceHeight;

    Integer num0PosX = numButtonMiddlePosX;
    Integer num0PosY = fourthLineButtonPosY;
    JButton num0Button = new JButton("0");
    num0Button.setFont(numButtonFont);
    num0Button.setBounds(num0PosX, num0PosY, numButtonDimension.width, numButtonDimension.height);
    this.components.put(buttonTypes.num0, num0Button);

    // fifth line buttons
    Integer actionButtonSpaceHeight = 40;
    Font actionButtonFont = new Font("Arial", Font.PLAIN, 14);
    Integer actionButtonFixedHeight = 30;
    Integer actionButtonSpaceBetween = 20;

    Integer fifthLineButtonPosY = fourthLineButtonPosY + actionButtonFixedHeight + actionButtonSpaceHeight;
    
    // confirm button
    JButton confirmButton = new JButton("Confirmar");
    confirmButton.setFont(actionButtonFont);
    Integer confirmButtonWidth = confirmButton.getPreferredSize().width;
    
    Integer actionButtonInitialPosX = FRAME_WIDTH - 46;

    Integer confirmPosX = actionButtonInitialPosX - confirmButtonWidth;
    Integer confirmPosY = fifthLineButtonPosY;
    confirmButton.setBounds(confirmPosX, confirmPosY, confirmButtonWidth, actionButtonFixedHeight);
    this.components.put(buttonTypes.confirm, confirmButton);
    
    // correct button
    JButton correctButton = new JButton("Corrige");
    correctButton.setFont(actionButtonFont);
    Integer correctButtonWidth = correctButton.getPreferredSize().width;
    Integer correctPosX = confirmPosX - actionButtonSpaceBetween - correctButtonWidth;
    Integer correctPosY = fifthLineButtonPosY;
    correctButton.setBounds(correctPosX, correctPosY, correctButtonWidth, actionButtonFixedHeight);
    this.components.put(buttonTypes.correct, correctButton);

    // blank button
    JButton blankButton = new JButton("Branco");
    blankButton.setFont(actionButtonFont);
    Integer blankButtonWidth = blankButton.getPreferredSize().width;
    Integer blankPosX = correctPosX - actionButtonSpaceBetween - blankButtonWidth;
    Integer blankPosY = fifthLineButtonPosY;
    blankButton.setBounds(blankPosX, blankPosY, blankButtonWidth, actionButtonFixedHeight);
    this.components.put(buttonTypes.blank, blankButton);

    // sixth line buttons

    Integer sixLineButtonPosY = fifthLineButtonPosY + actionButtonFixedHeight + actionButtonSpaceHeight;
    
    // score
    JButton scoreButton = new JButton("Contagem");
    scoreButton.setFont(actionButtonFont);
    Integer scoreButtonWidth = scoreButton.getPreferredSize().width;
    Integer scorePosX = actionButtonInitialPosX - scoreButtonWidth;
    Integer scorePosY = sixLineButtonPosY;
    scoreButton.setBounds(scorePosX, scorePosY, scoreButtonWidth, actionButtonFixedHeight);
    this.components.put(buttonTypes.score, scoreButton);

    // options
    JButton optionsButton = new JButton("Opções");
    optionsButton.setFont(actionButtonFont);
    Integer optionsButtonWidth = optionsButton.getPreferredSize().width;
    Integer optionsPosX = blankPosX;
    Integer optionsPosY = sixLineButtonPosY;
    optionsButton.setBounds(optionsPosX, optionsPosY, optionsButtonWidth, actionButtonFixedHeight);
    this.components.put(buttonTypes.options, optionsButton);
  }
}
