#!/bin/sh
cd /app
echo "REACT_APP_POLLS_VIEWER_BACKEND_HOST=${POLLS_VIEWER_BACKEND_HOST}" >.env

# Start server
npm run start
