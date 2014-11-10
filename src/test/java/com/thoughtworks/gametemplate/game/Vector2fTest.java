package com.thoughtworks.gametemplate.game;


import com.thoughtworks.gametemplate.game.entities.Vector2f;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Vector2fTest {

    @Test
    public void shouldMakeVectorTwiceAsLongWhenScaledBy2() {
        // Arrange/setup/Given
        Vector2f vector = new Vector2f(1, 2);
        Vector2f vectorTimes2 = new Vector2f(2, 4);

        // Action/verb/When
        Vector2f scale = vector.scale(2);

        // Assert/verify/Then
        assertThat(scale, is(vectorTimes2));
    }
}