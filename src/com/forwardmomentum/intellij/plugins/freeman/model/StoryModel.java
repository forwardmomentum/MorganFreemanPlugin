package com.forwardmomentum.intellij.plugins.freeman.model;

import java.util.List;

/**
 * Created by forwardmomentum on 13.05.17.
 */
public class StoryModel {

    String id;
    String name;

    /**
     * Every story is sequence of steps
     */
    List<StepModel> steps;
}
