#!/bin/sh
cd /app
echo "REACT_APP_ELEVATOR_MULTITHREADING_BACKEND_HOST=${ELEVATOR_MULTITHREADING_BACKEND_HOST}" >.env

# Start server
npm run start
