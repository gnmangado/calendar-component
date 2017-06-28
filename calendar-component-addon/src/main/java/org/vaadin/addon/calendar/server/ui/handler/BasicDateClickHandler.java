/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.addon.calendar.server.ui.handler;

import org.vaadin.addon.calendar.server.ui.CalendarComponentEvents;

import java.util.Calendar;
import java.util.Date;

/**
 * Implements basic functionality needed to switch to day view when a single day
 * is clicked.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 */
@SuppressWarnings("serial")

public class BasicDateClickHandler implements CalendarComponentEvents.DateClickHandler {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.addon.calendar.ui.CalendarComponentEvents.DateClickHandler
     * #dateClick
     * (com.vaadin.addon.calendar.ui.CalendarComponentEvents.DateClickEvent)
     */
    @Override
    public void dateClick(CalendarComponentEvents.DateClickEvent event) {
        Date clickedDate = event.getDate();

        Calendar javaCalendar = event.getComponent().getInternalCalendar();
        javaCalendar.setTime(clickedDate);

        // as times are expanded, this is all that is needed to show one day
        Date start = javaCalendar.getTime();
        Date end = javaCalendar.getTime();

        setDates(event, start, end);
    }

    /**
     * Set the start and end dates for the event
     *
     * @param event
     *            The event that the start and end dates should be set
     * @param start
     *            The start date
     * @param end
     *            The end date
     */
    protected void setDates(CalendarComponentEvents.DateClickEvent event, Date start, Date end) {
        event.getComponent().setStartDate(start);
        event.getComponent().setEndDate(end);
    }
}