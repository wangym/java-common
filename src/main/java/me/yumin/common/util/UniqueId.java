/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package me.yumin.common.util;

import me.yumin.common.R;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-28
 */
public final class UniqueId {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static UniqueId me = new UniqueId();

    private String hostAddress;
    private MessageDigest messageDigest;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Random secureRandom = new SecureRandom();
    private UniqueTimer uniqueTimer = new UniqueTimer();

    /**
     *
     */
    private UniqueId() {
        try {
            hostAddress = NetUtil.getHostAddress();
            if (StringUtil.isEmpty(hostAddress) || "127.0.0.1".equals(hostAddress)) {
                hostAddress = String.valueOf(System.currentTimeMillis());
            }
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            R.LOG.error(e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @return UniqueId
     */
    public static UniqueId getInstance() {
        return me;
    }

    /**
     * @return currentTime-secureRandom-hostAddress-threadId
     */
    public String getUniqueId() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(uniqueTimer.currentTimeMillis());
        stringBuffer.append("-");
        stringBuffer.append(secureRandom.nextInt(8999) + 1000);
        stringBuffer.append("-");
        stringBuffer.append(hostAddress);
        stringBuffer.append("-");
        stringBuffer.append(Thread.currentThread().hashCode());

        return stringBuffer.toString();
    }

    /**
     * @return currentTimeMillis
     */
    public long getUniqueTime() {
        return uniqueTimer.currentTimeMillis();
    }

    /**
     * @return hash
     */
    public byte[] getUniqueIdHash() {
        return hash(getUniqueId());
    }

    /**
     * @return hashString
     */
    public String getUniqueIdHashString() {
        return hashString(getUniqueId());
    }

    /**
     * @param bytes byte[]
     * @return String
     */
    private String bytesToString(byte[] bytes) {
        int length = bytes.length;
        char[] out = new char[length << 1];
        for (int x = 0, y = 0; x < length; x++) {
            out[y++] = digits[(0xF0 & bytes[x]) >>> 4];
            out[y++] = digits[0x0F & bytes[x]];
        }

        return new String(out);
    }

    /**
     * @param string String
     * @return byte[]
     */
    private byte[] hash(String string) {
        reentrantLock.lock();
        try {
            byte[] bytes = messageDigest.digest(string.getBytes());
            if (null == bytes || 16 != bytes.length) {
                throw new IllegalArgumentException("digest happen exception");
            }

            return bytes;
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * @param string String
     * @return String
     */
    private String hashString(String string) {
        return bytesToString(hash(string));
    }

    /**
     *
     */
    private final class UniqueTimer {
        private AtomicLong currentTimeMillis = new AtomicLong(System.currentTimeMillis());

        /**
         * @return currentTimeMillis
         */
        public long currentTimeMillis() {
            return this.currentTimeMillis.incrementAndGet();
        }
    }
}
