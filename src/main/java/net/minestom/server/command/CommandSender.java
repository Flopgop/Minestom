package net.minestom.server.command;

import net.minestom.server.entity.Player;
import net.minestom.server.permission.PermissionHandler;
import org.jetbrains.annotations.NotNull;

/**
 * Represents something which can send commands to the server.
 * <p>
 * Main implementations are {@link Player} and {@link ConsoleSender}.
 */
public interface CommandSender extends PermissionHandler {

    /**
     * Sends a raw string message.
     *
     * @param message the message to send
     */
    void sendMessage(@NotNull String message);

    /**
     * Sends multiple raw string messages.
     *
     * @param messages the messages to send
     */
    default void sendMessage(@NotNull String[] messages) {
        for (String message : messages) {
            sendMessage(message);
        }
    }

    /**
     * Gets if the sender is a {@link Player}.
     *
     * @return true if 'this' is a player, false otherwise
     */
    default boolean isPlayer() {
        return this instanceof Player;
    }

    /**
     * Gets if the sender is a {@link ConsoleSender}.
     *
     * @return true if 'this' is the console, false otherwise
     */
    default boolean isConsole() {
        return this instanceof ConsoleSender;
    }

    /**
     * Casts this object to a {@link Player}.
     * No checks are performed, {@link ClassCastException} can very much happen.
     *
     * @see #isPlayer()
     */
    default Player asPlayer() {
        return (Player) this;
    }

    /**
     * Casts this object to a {@link ConsoleSender}.
     * No checks are performed, {@link ClassCastException} can very much happen.
     *
     * @see #isConsole()
     */
    default ConsoleSender asConsole() {
        return (ConsoleSender) this;
    }
}
