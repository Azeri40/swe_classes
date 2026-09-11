import threading, time
from collections import deque

class Mutex:
    def __init__(self):
        self._token = deque([None])     # token present = unlocked
        self._owner = None

    def acquire(self):
        while True:
            try:
                self._token.pop()       # take the token or fail, atomically
            except IndexError:          # someone else holds it
                time.sleep(0)           # yield so the holder can run
                continue
            self._owner = threading.get_ident()
            return

    def release(self):
        if self._owner != threading.get_ident():
            raise RuntimeError("release by non-owner")
        self._owner = None
        self._token.append(None)

    __enter__ = acquire
    def __exit__(self, *exc):
        self.release()
