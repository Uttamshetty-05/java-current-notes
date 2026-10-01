# JVM and garbage collection (short field guide)

You do not need to be a HotSpot engineer. You do need to know which collector you run and how to read a GC log.

## Collectors you will actually see

- **G1** — default for a long time; good general purpose heap.
- **ZGC** — low pause, great for larger heaps and latency SLAs (Java 21+ is production-ready).
- **Shenandoah** — similar low-pause story, common on some distros.

## Flags worth knowing

```
java -XX:+UseG1GC -Xms512m -Xmx512m
java -XX:+UseZGC -Xmx4g
```

Set `-Xms` and `-Xmx` to the same value in containers so the heap does not resize under load.

## What to look at in production

- Allocation rate and old-gen occupancy
- Pause time p99, not just average
- Thread dumps when the app “hangs” (often lock or pool exhaustion, not GC)
- Native memory (direct buffers, metaspace) when RSS grows but heap looks fine

## Container note

In Kubernetes, prefer JDK 17+ container awareness. Size the memory limit above heap + metaspace + native, or the kernel OOM-killer will look like a random crash.
