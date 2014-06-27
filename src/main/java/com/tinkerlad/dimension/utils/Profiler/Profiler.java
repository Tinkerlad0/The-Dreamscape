package com.tinkerlad.dimension.utils.Profiler;

import java.lang.reflect.Method;

public class Profiler {

	public final static String PROFILE_MEMORY = "-mem";
	public final static String PROFILE_TIME = "-time";
	public final static String PROFILE_ALL = "-all";
	private String theProfile = PROFILE_ALL;
	private Object theInstance = null;

	public Profiler(String className, String profile) {
		try {
			theInstance = Class.forName(className).newInstance();
		} catch (Exception ex) {
			System.out.println("Cannot instantiate class due to exception" + ex);
			System.exit(1);
		}    // catch
		if (!(profile.equals(PROFILE_MEMORY) ||
				      profile.equals(PROFILE_TIME) ||
				      profile.equals(PROFILE_ALL))) {
			doUsage();
			System.exit(1);
		}    // if
	}       // Profiler()

	public static void doUsage() {
		System.out.println("");
		System.out.println("Usage:");
		System.out.println("$java Profiler MyClass <option>");
		System.out.println("where <option> must be one of:");
		System.out.println("-mem = Show memory usage for all methods");
		System.out.println("-time = Show execution time for all methods");
		System.out.println("-all = Show all profile information for all methods ");
		System.out.println("");
	}    // doUsage()

	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			doUsage();
			System.exit(1);
		}    // if

		System.out.println("Beginning profiling of class " + args[0]);
		Profiler theProfiler = new Profiler(args[0], args[1]);
		theProfiler.doProfile();
		System.out.println("Done!");
	}    // main()

	public void doProfile() throws Exception {
		Method[] methods =
				theInstance.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method theMethod = methods[i];
			MemoryCheck theMemCheckAnnotation =
					theMethod.getAnnotation(MemoryCheck.class);
			ExecTime theExecTimeAnnotation =
					theMethod.getAnnotation(ExecTime.class);

			long freeMemoryBefore = 0;
			long freeMemoryAfter = 0;

			long timeBefore = 0;
			long timeAfter = 0;

			if (theMemCheckAnnotation != null &&
					    (theProfile.equals(PROFILE_MEMORY) ||
							     theProfile.equals(PROFILE_ALL))) {
				System.gc();
				freeMemoryBefore = Runtime.getRuntime().freeMemory();
			}    // if

			if (theExecTimeAnnotation != null &&
					    (theProfile.equals(PROFILE_TIME) ||
							     theProfile.equals(PROFILE_ALL))) {
				timeBefore = System.currentTimeMillis();
			}    // if

			if (theMemCheckAnnotation != null ||
					    theExecTimeAnnotation != null) {
				System.out.println("Profiling " +
						                   theMethod.getName());
				theMethod.invoke(theInstance, null);
			}    // if

			if (theMemCheckAnnotation != null &&
					    (theProfile.equals(PROFILE_MEMORY) ||
							     theProfile.equals(PROFILE_ALL))) {
				freeMemoryAfter = Runtime.getRuntime().freeMemory();
				double memoryUsed = freeMemoryBefore - freeMemoryAfter;
				if (theMemCheckAnnotation.size().equals(MemoryCheck.KB)) {
					memoryUsed = memoryUsed / 1024;
				} else if (theMemCheckAnnotation.size().
						                                       equals(MemoryCheck.MB)) {
					memoryUsed = memoryUsed / 1024000;
				}    // if
				System.out.println("Profiler: The memory required to execute" + theMethod.getName() + " for class " +
						                   theInstance.getClass().getName() + " was " +
						                   memoryUsed + theMemCheckAnnotation.size());
			}    // if

			if (theExecTimeAnnotation != null &&
					    (theProfile.equals(PROFILE_TIME) ||
							     theProfile.equals(PROFILE_ALL))) {
				timeAfter = System.currentTimeMillis();
				System.out.println("Profiler: The time required to execute " + theMethod.getName() + " for class " +
						                   theInstance.getClass().getName() + " was " +
						                   (timeAfter - timeBefore) + " milliseconds");
			}    // if
		}       // for i
	}          // doProfile()
}
