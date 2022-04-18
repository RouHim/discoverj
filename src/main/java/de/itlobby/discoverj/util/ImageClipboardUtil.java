package de.itlobby.discoverj.util;

import de.itlobby.discoverj.models.TransferableImage;
import javafx.embed.swing.SwingFXUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

/**
 * Created by Rouven Himmelstein on 27.01.2016.
 */
public class ImageClipboardUtil implements ClipboardOwner {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    public void copyImage(javafx.scene.image.Image bi) {
        try {
            TransferableImage trans = new TransferableImage(SwingFXUtils.fromFXImage(bi, null));
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            c.setContents(trans, this);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        LOG.error("Lost ClipBrd ownership");
    }
}
