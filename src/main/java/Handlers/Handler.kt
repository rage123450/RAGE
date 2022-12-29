package Handlers

import EventID
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Retention(RetentionPolicy.RUNTIME)
annotation class Handler(val op: EventID = EventID.NO, val ops: Array<EventID> = [])