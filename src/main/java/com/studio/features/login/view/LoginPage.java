package com.studio.features.login.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import com.studio.core.constants.AppStrings;
import com.studio.core.shared_widgets.AppButton;
import com.studio.core.shared_widgets.AppFiled;
import com.studio.core.shared_widgets.AppLable;

public class LoginPage extends JPanel {
    public AppFiled usernameField = new AppFiled();
    public JPasswordField passwordField = new JPasswordField(); // استخدم حقل كلمة مرور مناسب
    public AppButton submitButton = new AppButton(AppStrings.LOGIN);

    public LoginPage() {
        this.setSize(500, 500);
        JPanel mainPnel = new JPanel();
        mainPnel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        mainPnel.setLayout(new BoxLayout(mainPnel, BoxLayout.Y_AXIS));

        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton.setPreferredSize(new Dimension(150, 40));
        submitButton.setMaximumSize(new Dimension(150, 40));
        AppLable userLabel = new AppLable(AppStrings.USER_NAME);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPnel.add(userLabel);
        mainPnel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPnel.add(usernameField);
         passwordField.setEchoChar('•');
        mainPnel.add(Box.createRigidArea(new Dimension(0, 15)));
        AppLable pasLable = new AppLable(AppStrings.USER_PASSWORD);
        pasLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPnel.add(pasLable);
        mainPnel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPnel.add(passwordField);


        KeyAdapter enterListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();
                }
            }
        };
        usernameField.addKeyListener(enterListener);
        passwordField.addKeyListener(enterListener);
        
        SwingUtilities.invokeLater(() -> usernameField.requestFocusInWindow());

        mainPnel.add(Box.createRigidArea(new Dimension(0, 25)));
        mainPnel.add(submitButton);

        this.add(mainPnel);
        this.setVisible(true);

    }

}
