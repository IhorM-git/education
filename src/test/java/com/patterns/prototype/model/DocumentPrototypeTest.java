package com.patterns.prototype.model;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DocumentPrototypeTest {

    @Test
    void testCloneShouldCopyAllFields() {
        Document original = new Document(
                "Design Patterns",
                "Prototype example",
                new ArrayList<>(Arrays.asList("img1.png", "img2.png"))
        );

        Document copy = (Document) original.clone();

        assertNotSame(original, copy); // це новий об’єкт
        assertEquals(original.getTitle(), copy.getTitle());
        assertEquals(original.getContent(), copy.getContent());
        assertEquals(original.getImages(), copy.getImages());
        assertNotSame(original.getImages(), copy.getImages());
    }

    @Test
    void testChangingCopyShouldNotAffectOriginal() {
        Document original = new Document(
                "Design Patterns",
                "Prototype example",
                new ArrayList<>(Arrays.asList("img1.png", "img2.png"))
        );

        Document copy = (Document) original.clone();
        copy.setTitle("Modified Title");
        copy.getImages().add("img3.png");

        assertEquals("Design Patterns", original.getTitle());
        assertEquals(2, original.getImages().size());
        assertEquals("Modified Title", copy.getTitle());
        assertEquals(3, copy.getImages().size());
    }

    @Test
    void testCloneOfEmptyDocument() {
        Document empty = new Document(null, null, new ArrayList<>());

        Document copy = (Document) empty.clone();

        assertNotSame(empty, copy);
        assertNull(copy.getTitle());
        assertNull(copy.getContent());
        assertEquals(0, copy.getImages().size());
    }

}