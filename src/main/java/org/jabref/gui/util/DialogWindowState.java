package org.jabref.gui.util;

/**
 * This class is used to store the size and position of dialog windows so that
 * these properties stay consistent when they are closed and re-opened
 */
public record DialogWindowState(double x, double y, double height, double width) {
}
