/*
 * Copyright (C) 2014-2020 Arpit Khurana <arpitkh96@gmail.com>, Vishal Nehra <vishalmeham2@gmail.com>,
 * Emmanuel Messulam<emmanuelbendavid@gmail.com>, Raymond Lai <airwave209gt at gmail.com> and Contributors.
 *
 * This file is part of Amaze File Manager.
 *
 * Amaze File Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.filesystem

import com.amaze.filemanager.shadows.ShadowMultiDex
import com.amaze.filemanager.shadows.ShadowSmbUtil
import com.amaze.filemanager.shadows.ShadowSmbUtil.Companion.PATH_CANNOT_RENAME_OLDFILE
import com.amaze.filemanager.utils.OpenMode.SMB
import org.junit.Test
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowAsyncTask

@Config(shadows = [ShadowSmbUtil::class, ShadowMultiDex::class, ShadowAsyncTask::class])
class SmbOperationsTest : AbstractOperationsTestBase() {

    @Test
    fun testRenameFileAccessDenied() {
        super.testRenameFileAccessDenied(SMB,
                PATH_CANNOT_RENAME_OLDFILE,
                "smb://user:password@1.2.3.4/cannot/rename.file.new")
    }
}
